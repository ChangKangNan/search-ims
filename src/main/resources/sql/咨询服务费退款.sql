#自动生成的版本信息3
select zxfwf.contract_id,#contract_id number hidden=1
       contract_service.department,#部门
       contract_service.salesman,#业务员
       contract.sign_date,#合同日期
       contract.kyc_ids,#交易对手
       contract.no          as contract_no,#合同号
       contract_service.currency,#币种
       service_cost.lot_nos as lot,#lot
       contract_service.direction,#方向
       zxfwf.back_amount#可退金额 number
from (
         select contract_id, sum(zx_amount) back_amount
         from (
                  select contract_id, sum(amount) zx_amount
                  from funding_flow_log ffl
                  where amount_use = '咨询服务费'
                    and amount_direction = '付'
                    and cancel = 0
                  group by contract_id
                  union all
                  select contract_id, (-1) * sum(amount) zx_amount
                  from funding_flow_log
                  where amount_use = '咨询服务费(退款)'
                    and amount_direction = '收'
                    and cancel = 0
                  group by contract_id
              ) sub
         group by contract_id
     ) zxfwf
         left join contract on contract.id = zxfwf.contract_id
         left join contract_service on contract_service.contract_id = zxfwf.contract_id
         left join (select contract_id, group_concat(lot_no) lot_nos
                    from contract_service_cost
                    where deleted = 0
                    group by contract_id
) service_cost on service_cost.contract_id = zxfwf.contract_id
where 1