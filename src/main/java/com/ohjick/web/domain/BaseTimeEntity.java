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
 * JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 필드들(createdDate, modifiedDate)을
 * 컬럼으로 인식
 * 
 * @EntityListeners(AuditingEntityListeners.class)
 * BaseTimeEntity클래스에 Auditing 기능을 포함시킨다.
 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {
	/**
	 * Entity가 생성되어 저장될 때 시간이 자동 저장
	 */
	@CreatedDate
	private LocalDateTime createdDate;
	
	/**
	 * 조회한 Entity의 값을 변경할 때 시간이 자동 저장
	 */
	@LastModifiedDate
	private LocalDateTime modifiedDate;
}
