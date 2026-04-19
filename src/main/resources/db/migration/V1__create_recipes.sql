CREATE TABLE users
(
    id         BIGSERIAL PRIMARY KEY,
    username   TEXT        NOT NULL,
    email      TEXT        NOT NULL UNIQUE,
    password   TEXT        NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE TABLE recipes
(
    id         BIGSERIAL PRIMARY KEY,
    user_id    BIGINT      NOT NULL REFERENCES users (id),
    title      TEXT        NOT NULL,
    image_url  TEXT,
    memo       TEXT,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE TABLE ingredients
(
    id         BIGSERIAL PRIMARY KEY,
    recipe_id  BIGINT      NOT NULL REFERENCES recipes (id),
    user_id    BIGINT      NOT NULL REFERENCES users (id),
    name       TEXT        NOT NULL,
    amount     TEXT,
    unit       TEXT        NOT NULL,
    "order"    BIGINT      NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE TABLE steps
(
    id         BIGSERIAL PRIMARY KEY,
    recipe_id  BIGINT      NOT NULL REFERENCES recipes (id),
    user_id    BIGINT      NOT NULL REFERENCES users (id),
    text       TEXT        NOT NULL,
    "order"    BIGINT      NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE TABLE tags
(
    id         BIGSERIAL PRIMARY KEY,
    recipe_id  BIGINT      NOT NULL REFERENCES recipes (id),
    user_id    BIGINT      NOT NULL REFERENCES users (id),
    name       TEXT        NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE TABLE set_meals
(
    id         BIGSERIAL PRIMARY KEY,
    user_id    BIGINT      NOT NULL REFERENCES users (id),
    title      TEXT        NOT NULL,
    memo       TEXT,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE TABLE set_meal_recipes
(
    id          BIGSERIAL PRIMARY KEY,
    set_meal_id BIGINT      NOT NULL REFERENCES set_meals (id),
    recipe_id   BIGINT      NOT NULL REFERENCES recipes (id),
    user_id     BIGINT      NOT NULL REFERENCES users (id),
    created_at  TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at  TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE TABLE calendar
(
    id         BIGSERIAL PRIMARY KEY,
    user_id    BIGINT      NOT NULL REFERENCES users (id),
    recipe_id  BIGINT      NOT NULL REFERENCES recipes (id),
    start      DATE        NOT NULL,
    color      TEXT        NOT NULL DEFAULT 'BLUE',
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE TABLE shopping_list
(
    id         BIGSERIAL PRIMARY KEY,
    user_id    BIGINT      NOT NULL REFERENCES users (id),
    name       TEXT        NOT NULL,
    amount     TEXT,
    unit       TEXT        NOT NULL,
    status     BOOLEAN     NOT NULL DEFAULT FALSE,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);