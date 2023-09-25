create table tests
(
    t_id      number
        constraint TESTS_PK
            primary key,
    test_name varchar2(1000)
)
/


create table test_quest
(
    q_id  number not null
      constraint TEST_QUEST_PK
        primary key,
    q_numb number not null,
    quest  varchar2(4000)
)
/

create table tests2quest
(
  t2id  number
    constraint TESTS2QUEST_TESTS_T_ID_FK
      references tests (t_id)
        on delete cascade,
  q2id number
  constraint TESTS2QUEST_TEST_QUEST_Q_ID_FK
     references test_quest (q_id)
      on delete cascade,
  constraint tests2quest_PK
    primary key (t2id, q2id)
)
/

create table test_answer
(
    an_id number
        constraint TEST_ANSWER_PK
            primary key,
    answer varchar2(1000),
    answer_good char(1) default 'N' check ( answer_good in ('Y','N') ),
    q2id  int
        constraint TEST_ANSWER_TEST_QUESR_Q_ID_FK
            references test_quest (q_id)
                on delete cascade
)
/
