CREATE TYPE phone_type AS ENUM ('mobile', 'fixed', 'work', 'Emergency');

CREATE TABLE phones (
    phone_id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    person_id BIGINT NOT NULL REFERENCES persons(person_id) ON DELETE CASCADE,
    phone_number VARCHAR(15) NOT NULL UNIQUE,
    phone_type phone_type,
    created_at TIMESTAMPTZ DEFAULT NOW(),
    update_at TIMESTAMPTZ DEFAULT NOW()
);

CREATE INDEX idx_phone_type ON phones USING btree (phone_type);