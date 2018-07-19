  --查询sql
  select u.id, u.name, u.logo from tbl_user_project up, tbl_user u , tbl_project p where up.tbl_user_id = u.id
and up.tbl_project_id = 4  and u.enabled = 1 and p.id= up.tbl_project_id
and exists(select 1 from tbl_organization o , tbl_user_organization uo where o.id=p.tbl_organization_id and uo. tbl_organization_id = o.id and uo.tbl_user_id=u.id)
union
select u.id, u.name, u.logo from tbl_team t,tbl_user_team ut ,tbl_project p ,tbl_project_team pt ,tbl_user u
where t.id=ut.tbl_team_id and u.id=ut.tbl_user_id and p.id=pt.tbl_project_id and pt.tbl_team_id=ut.tbl_team_id
and p.id = 4  and u.enabled = 1 
and  exists(select 1 from tbl_organization o , tbl_user_organization uo where o.id=p.tbl_organization_id and uo. tbl_organization_id = o.id and uo.tbl_user_id=u.id)

select u.id from tbl_user_project up, tbl_user u , tbl_project p where up.tbl_user_id = u.id
and up.tbl_project_id = 7  and u.enabled = 1 and p.id= up.tbl_project_id
and p.tbl_organization_id is null