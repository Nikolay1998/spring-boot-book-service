INSERT INTO public.author(	 surname, name, gender)
	VALUES ('Руэл Толкин', 'Джон Рональд', 'м');
INSERT INTO public.author(	 surname, name, gender)
	VALUES ('Артур Игнейшус', 'Конан Дойл ', 'м');
INSERT INTO public.author(	 surname, name, gender)
	VALUES ('Дюма', 'Александр', 'м');

INSERT INTO public.genre(name)	VALUES ('фэнтези');
INSERT INTO public.genre(name)	VALUES ('детектив');
INSERT INTO public.genre(name)	VALUES ('приключения');

INSERT INTO public.book(
	 name, count, author_id, genre_id)
	VALUES ('Властелин колец', 10, 8, 8);
INSERT INTO public.book(
	 name, count, author_id, genre_id)
	VALUES ('Хоббит', 5, 8, 8);
INSERT INTO public.book(
	 name, count, author_id, genre_id)
	VALUES ('Приключения Шерлока Холмса', 5, 9, 9);
INSERT INTO public.book(
	 name, count, author_id, genre_id)
	VALUES ('Три мушкетера ', 3, 10, 10);