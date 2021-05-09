package com.jockjock.jpa.domain.relation.post;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPost is a Querydsl query type for Post
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPost extends EntityPathBase<Post> {

    private static final long serialVersionUID = 1052521836L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPost post = new QPost("post");

    public final com.jockjock.jpa.domain.relation.board.QBoard board;

    public final StringPath content = createString("content");

    public final DateTimePath<java.util.Date> create_date = createDateTime("create_date", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath title = createString("title");

    public final DateTimePath<java.util.Date> update_date = createDateTime("update_date", java.util.Date.class);

    public final StringPath user_id = createString("user_id");

    public QPost(String variable) {
        this(Post.class, forVariable(variable), INITS);
    }

    public QPost(Path<? extends Post> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPost(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPost(PathMetadata metadata, PathInits inits) {
        this(Post.class, metadata, inits);
    }

    public QPost(Class<? extends Post> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.board = inits.isInitialized("board") ? new com.jockjock.jpa.domain.relation.board.QBoard(forProperty("board")) : null;
    }

}

