CREATE DATABASE aristo_vacation_Service;

CREATE SCHEMA IF NOT EXISTS aristovacationService;

DROP USER IF EXISTS "aristo_owner";
CREATE USER aristo_owner WITH ENCRYPTED PASSWORD 'postgres';

CREATE ROLE aristo_owner_app_role;
GRANT ALL ON DATABASE aristo_vacation_Service TO aristo_owner;

GRANT USAGE on SCHEMA aristovacationService to aristo_owner_app_role;
GRANT SELECT, INSERT, DELETE, UPDATE on ALL TABLES IN SCHEMA aristovacationService to aristo_owner_app_role;
