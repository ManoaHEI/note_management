INSERT INTO student VALUES
    (22000 , 'John' , 'Doe' , 'M' , 'L1'),
    (22001 , 'Mark' , 'Markinson' , 'M' , 'L1'),
    (22002 , 'Tania' , 'Davis' , 'F' , 'L1'),
    (22003 , 'Ursula' , 'Biden' , 'F' , 'L1'),
    (22004 , 'Max' , 'Torvald' , 'M' , 'L1'),
    (22005 , 'Alvin' , 'Newman' , 'M' , 'L1'),
    (22006 , 'Kate' , 'Larson' , 'F' , 'L1'),
    (22007 , 'Lucie' , 'Vatanen' , 'F' , 'L1'),
    (22008 , 'Dave' , 'Seville' , 'M' , 'L1'),
    (22009 , 'Anthony' , 'Joshua' , 'M' , 'L1'),
    (22010 , 'Marie' , 'Jeanne' , 'F' , 'L1'),
    (22011 , 'Alice' , 'Bastille' , 'F' , 'L1'),
    (22012 , 'George' , 'Madden' , 'M' , 'L1'),
    (22013 , 'Nathan' , 'Drake' , 'M' , 'L1'),
    (22014 , 'Anne' , 'Lagrange' , 'F' , 'L1'),
    (22015 , 'Lise' , 'Hollande' , 'F' , 'L1'),
    (22016 , 'François' , 'Deschamps' , 'M' , 'L1'),
    (22017 , 'Didier' , 'Lelouche' , 'M' , 'L1'),
    (22018 , 'Alya' , 'Berger' , 'F' , 'L1'),
    (22019 , 'Patricia' , 'Duprés' , 'F' , 'L1');

INSERT INTO courses(course_name, credits) VALUES
    ('PROG1' , 6),
    ('PROG2' , 6),
    ('PROG3' , 6),
    ('DONNÉES1' , 3),
    ('DONNÉES2' , 3),
    ('WEB1' , 3),
    ('WEB2' , 3),
    ('SYS1' , 2),
    ('SYS2' , 2);

INSERT INTO exams(percentage, id_course) VALUES
    --PROG1
    (50 , 1),
    (30 , 1),
    (20 , 1),
    --PROG2
    (40 , 2),
    (60 , 2),
    --DONNÉES1
    (30 , 4),
    (70 , 4),
    --WEB1
    (25 , 6),
    (75 , 6),
    --WEB2
    (20 , 7),
    (80 , 7),
    --SYS1
    (30 , 8),
    (20 , 8),
    (50 , 8),
    --SYS2
    (100 , 9);

INSERT INTO take_exams VALUES
    --PROG1
    (1 , 22000 , 10);