--Affiche tous les étudiants avec leurs matières et les notes des examens de cette matière
--On peut ajouter des conditions avec WHERE
SELECT (std , firstname , lastname , gender , level , note  , course_name) FROM student
    INNER JOIN take_exams te on student.std = te.id_student
    INNER JOIN exams e on e.id_exams = te.id_exams
    INNER JOIN courses c on c.id_course = e.id_course;

--Affiche la note moyenne de tous les étudiants dans une matière spécifique
SELECT (course_name , std ,
        (select sum(notess)
         from (SELECT (note * exams.percentage / 100) as notess
               FROM exams
                        INNER JOIN courses c ON c.id_course = exams.id_course
                        INNER JOIN take_exams ON take_exams.id_exams = exams.id_exams
                        INNER JOIN student s on s.std = take_exams.id_student
               WHERE course_name = 'PROG1'
                 AND std = 22001
               GROUP BY id_student, exams.id_exams, note, exams.percentage) as average)
           )FROM exams
                     INNER JOIN courses c on c.id_course = exams.id_course
                     INNER JOIN take_exams ON take_exams.id_exams = exams.id_exams
                     INNER JOIN student s on s.std = take_exams.id_student
WHERE course_name = 'PROG1'
group by course_name, std;

--Affiche la note moyenne d'un étudiant dans une matière spécifique
SELECT (course_name , std ,
        (SELECT sum(notess)
        FROM (SELECT (note * exams.percentage / 100) AS notess
            FROM exams
                INNER JOIN courses c ON c.id_course = exams.id_course
                INNER JOIN take_exams ON take_exams.id_exams = exams.id_exams
                INNER JOIN student s ON s.std = take_exams.id_student
                WHERE course_name = 'PROG1'
                AND std = 22001
                GROUP BY id_student, exams.id_exams, note, exams.percentage) AS average)
       )FROM exams
            INNER JOIN courses c ON c.id_course = exams.id_course
            INNER JOIN take_exams ON take_exams.id_exams = exams.id_exams
            INNER JOIN student s ON s.std = take_exams.id_student
WHERE course_name = 'PROG1'
   AND std = 22001
GROUP BY course_name, std;

--Affiche la moyenne générale d'un étudiant (utilise la requete précédente)
--Formule pour calculer la moyenne d'un étudiant dans chaque matière : somme des moyennes de l'élève dans chaque matière

--Affiche un examen avec tous les élèves qui y participent et la matière
SELECT (exams.id_exams , course_name , std , firstname , lastname , gender , level , percentage , note) FROM exams
    INNER JOIN courses c on c.id_course = exams.id_course
    INNER JOIN take_exams te on exams.id_exams = te.id_exams
    INNER JOIN student s on s.std = te.id_student;

--Affiche la note moyenne des élèves dans un examen
SELECT (course_name , count(note * exams.percentage / 100))FROM exams
    INNER JOIN courses c on c.id_course = exams.id_course
    INNER JOIN take_exams ON take_exams.id_exams = exams.id_exams
group by course_name;

--Affiche l'étudiant ayant eu la note min / max obtenue dans un examen