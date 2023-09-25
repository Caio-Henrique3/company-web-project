package com.projeto.util;

import java.io.Serializable;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Interceptor
@Transacional
@Priority(Interceptor.Priority.APPLICATION)
public class TransacionalInterceptor implements Serializable {

	private static final long serialVersionUID = -594078225516468644L;

	@Inject
    private EntityManager manager;

    @AroundInvoke
    public Object invoke(InvocationContext context) throws Exception {
        EntityTransaction transacao = manager.getTransaction();
        boolean metodoExecutante = false;

        try {
            if (!transacao.isActive()) {
                transacao.begin();
                transacao.rollback();

                transacao.begin();

                metodoExecutante = true;
            }

            return context.proceed();
        } catch (Exception e) {
            if (transacao != null && metodoExecutante) {
                transacao.rollback();
            }

            throw e;
        } finally {
            if (transacao != null && transacao.isActive() && metodoExecutante) {
                transacao.commit();
            }
        }
    }

}
