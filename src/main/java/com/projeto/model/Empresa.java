package com.projeto.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.projeto.enums.TipoEmpresa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "empresa")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empresa implements Serializable {

	private static final long serialVersionUID = 8540319586100377349L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "rz_social", nullable = false)
	private String rzSocial;

	@Column(name = "nome_fantasia", nullable = false)
	private String nomeFantasia;

	@Column(name = "cnpj", nullable = false, length = 18)
	private String cnpj;

	@Column(name = "data_criacao", nullable = false)
	private Date dataCricao;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_empresa")
	private TipoEmpresa tipoEmpresa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ramo_atividade")
	private RamoAtividade ramoAtividade;

}
