package com.jockjock.jpa.domain.relation.member;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -1522911828L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMember member = new QMember("member1");

    public final com.jockjock.jpa.embedded.QAddress homeAddress;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final ListPath<com.jockjock.jpa.domain.relation.order.Order, com.jockjock.jpa.domain.relation.order.QOrder> orders = this.<com.jockjock.jpa.domain.relation.order.Order, com.jockjock.jpa.domain.relation.order.QOrder>createList("orders", com.jockjock.jpa.domain.relation.order.Order.class, com.jockjock.jpa.domain.relation.order.QOrder.class, PathInits.DIRECT2);

    public final com.jockjock.jpa.embedded.QPeriod workPeriod;

    public QMember(String variable) {
        this(Member.class, forVariable(variable), INITS);
    }

    public QMember(Path<? extends Member> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMember(PathMetadata metadata, PathInits inits) {
        this(Member.class, metadata, inits);
    }

    public QMember(Class<? extends Member> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.homeAddress = inits.isInitialized("homeAddress") ? new com.jockjock.jpa.embedded.QAddress(forProperty("homeAddress")) : null;
        this.workPeriod = inits.isInitialized("workPeriod") ? new com.jockjock.jpa.embedded.QPeriod(forProperty("workPeriod")) : null;
    }

}

