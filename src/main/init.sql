/*
*  view for question Version n
 */

if exists(select 1 from sys.views where name='vw_question_version_unique' and type='v')
drop view vw_question_version_unique;

create view vw_question_version_unique as
select * from vw_question_version vqv
inner join mdl_question mq on mq.id = vqv.questionId ;

/*
 * view for question versions
 */

create view vw_question_version as

select
    X.versions,
    X.questionbankentryid,
    (
        select questionId from mdl_question_versions mqv
        where mqv.version= X.versions
          and mqv.questionbankentryid =X.questionbankentryid
    ) as questionId
from (
         select
             count(*) as versions,
             questionbankentryid
         from mdl_question_versions
         group by questionbankentryid ) X;

/*
 * view for custom_field data
 */

select * from vw_custom_field_category_data where instanceid =9 ;

create view vw_custom_field_category_data as
select
    mcf.name as property_name,
    mcd.value,
    mcd.intvalue,
    mcc.name as category_name ,
    mcd.instanceid,
    mcd.id
from mdl_customfield_data mcd
inner join mdl_customfield_field mcf on mcf.id = mcd.fieldid
inner join mdl_customfield_category mcc  on mcf.categoryid = mcc.id
