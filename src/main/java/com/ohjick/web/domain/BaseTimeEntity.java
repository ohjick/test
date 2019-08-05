package com.ohjick.web.domain;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;


/**
 * @author ohjick
 * 
 * @MappedSuperclass
 * JPA Entity Ŭ�������� BaseTimeEntity�� ����� ��� �ʵ��(createdDate, modifiedDate)��
 * �÷����� �ν�
 * 
 * @EntityListeners(AuditingEntityListeners.class)
 * BaseTimeEntityŬ������ Auditing ����� ���Խ�Ų��.
 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {
	/**
	 * Entity�� �����Ǿ� ����� �� �ð��� �ڵ� ����
	 */
	@CreatedDate
	private LocalDateTime createdDate;
	
	/**
	 * ��ȸ�� Entity�� ���� ������ �� �ð��� �ڵ� ����
	 */
	@LastModifiedDate
	private LocalDateTime modifiedDate;
}
