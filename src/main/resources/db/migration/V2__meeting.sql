create table simple_meeting
(
    id int auto_increment,
    title varchar(255) null,
    user_id int null,
    date_start timestamp,
    date_end timestamp,
    constraint simple_meeting_pk
        primary key (id),
    constraint simple_meeting_user_id_fk
        foreign key (user_id) references user (id)
            on update cascade on delete cascade
);

create table ref_simple_meeting_simple_tag
(
    id int auto_increment,
    meeting_id int null,
    tag_id int null,
    constraint ref_simple_meeting_simple_tag_pk
        primary key (id),
    constraint ref_simple_meeting_simple_tag_simple_meeting_id_fk
        foreign key (meeting_id) references simple_meeting (id)
            on update cascade on delete cascade,
    constraint ref_simple_meetingmeeting_simple_tag_tag_id_fk
        foreign key (tag_id) references tag (id)
            on update cascade on delete cascade
);
