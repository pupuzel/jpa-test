package com.jockjock.jpa.domain.relation.board;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoard is a Querydsl query type for Board
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBoard extends EntityPathBase<Board> {

    private static final long serialVersionUID = 192948828L;

    public static final QBoard board = new QBoard("board");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<com.jockjock.jpa.domain.relation.post.Post, com.jockjock.jpa.domain.relation.post.QPost> posts = this.<com.jockjock.jpa.domain.relation.post.Post, com.jockjock.jpa.domain.relation.post.QPost>createList("posts", com.jockjock.jpa.domain.relation.post.Post.class, com.jockjock.jpa.domain.relation.post.QPost.class, PathInits.DIRECT2);

    public final StringPath title = createString("title");

    public QBoard(String variable) {
        super(Board.class, forVariable(variable));
    }

    public QBoard(Path<? extends Board> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBoard(PathMetadata metadata) {
        super(Board.class, metadata);
    }

}

