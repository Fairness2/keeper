create table ref_simple_meeting_user
(
    id int auto_increment,
    meeting_id int null,
    user_id int null,
    constraint ref_simple_meeting_user_pk
        primary key (id),
    constraint ref_simple_meeting_user_simple_meeting_id_fk
        foreign key (meeting_id) references simple_meeting (id)
            on update cascade on delete cascade,
    constraint ref_simple_meeting_user_user_id_fk
        foreign key (user_id) references user (id)
            on update cascade on delete cascade
);
