
drop table if exists public.aristo_stops_transactions;
CREATE TABLE if NOT EXISTS public.aristo_stops_transactions (
                                                                id int PRIMARY KEY,
                                                                account_number varchar  NOT NULL,
                                                                start_date TIMESTAMP ,
                                                                end_date TIMESTAMP,
                                                                stop_code varchar  NOT NULL,
                                                                stop_reason varchar  NOT NULL,
                                                                donation_flag varchar  NOT NULL,
                                                                version integer not null default 0
);

insert into public.aristo_stops_transactions (id,account_number,start_date,end_date,stop_code,stop_reason,donation_flag,version) values(1,'12345',now(),now(),'ST','VA','N',0);
