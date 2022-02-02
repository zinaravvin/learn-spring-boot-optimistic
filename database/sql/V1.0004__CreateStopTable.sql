drop table if exists public.aristo_stops_transactions;
CREATE TABLE if not exists public.aristo_stops_transactions (
        id int PRIMARY KEY,
        account_number varchar  NOT NULL,
        start_date TIMESTAMP ,
        end_date TIMESTAMP,
        stop_code varchar  NOT NULL,
        stop_reason varchar  NOT NULL,
        donation_flag varchar  NOT NULL,
        version integer not null default 0
);