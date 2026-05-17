INSERT INTO notes (
    title,
    content,
    archived,
    created_at,
    updated_at
)
VALUES
    (
        'Shopping List',
        'Milk, Eggs, Bread, Coffee',
        FALSE,
        NOW(),
        NOW()
    ),
    (
        'Spring Boot Ideas',
        'Learn DTOs, validation, exception handling, and JWT authentication.',
        FALSE,
        NOW(),
        NOW()
    ),
    (
        'Workout Plan',
        'Walk 2 hours daily and do shoulder rehab exercises.',
        FALSE,
        NOW(),
        NOW()
    ),
    (
        'Archived Note',
        'This note is archived.',
        TRUE,
        NOW(),
        NOW()
    ),
    (
        'Books to Read',
        'Clean Code, Effective Java, Designing Data-Intensive Applications',
        FALSE,
        NOW(),
        NOW()
    );