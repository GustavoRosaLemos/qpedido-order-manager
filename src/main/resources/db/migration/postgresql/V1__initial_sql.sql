CREATE SCHEMA IF NOT EXISTS qpedido;

CREATE TABLE IF NOT EXISTS qpedido.table (
    id_table UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    capacity INTEGER NOT NULL,
    table_number VARCHAR NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT now()
);

CREATE TABLE IF NOT EXISTS qpedido.order (
    id_order UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    id_table UUID NOT NULL,
    status VARCHAR DEFAULT 'CREATED',
    number VARCHAR NOT NULL,
    owner_id UUID NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT now(),
    created_at TIMESTAMP WITH TIME ZONE DEFAULT now(),
    FOREIGN KEY (id_table) REFERENCES qpedido.table(id_table)
);

CREATE TABLE IF NOT EXISTS qpedido.category (
    id_category UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR NOT NULL,
    description VARCHAR NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT now(),
    created_at TIMESTAMP WITH TIME ZONE DEFAULT now()
);

CREATE TABLE IF NOT EXISTS qpedido.item (
    id_item UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    id_category UUID NOT NULL,
    name VARCHAR NOT NULL,
    description VARCHAR NOT NULL,
    price FLOAT NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT now(),
    created_at TIMESTAMP WITH TIME ZONE DEFAULT now(),
    FOREIGN KEY (id_category) REFERENCES qpedido.category(id_category)
);

CREATE TABLE IF NOT EXISTS qpedido.order_item (
    id_order_item UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    id_order UUID NOT NULL,
    id_item UUID NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT now(),
    FOREIGN KEY (id_order) REFERENCES qpedido.order(id_order),
    FOREIGN KEY (id_item) REFERENCES qpedido.item(id_item)
);