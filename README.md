# Raamatukogu rakendus
Projekti struktuur

Projektis saab eristada kahte liiki teenuseid: teenused, mis on seotud konkreetse tabeliga ja teenused, mis on seotud pigem äriloogikaga ja vajavad mitmete andmetabelite poole pöördumist. 

Äriloogika on struktureeritud eraldi library package alla.  Seal asuvasse LibraryService klassi on koondatud näiteks saveBookBorrow meetod, mis omakorda pöördub borrowService ja bookService klasside poole.  Eesmärk on projektis mitte liigselt koormata LibraryService klassi ja seeläbi projekt loetavamaks muuta.
#

Selleks, et raamatukogu töötaja saaks teha vajalikke toiminguid nagu näiteks  lisada laenutajaid (user-eid), on vajalik kõigepealt süsteemi sisse logida. Selleks kasutada logInRequest endpoint meetodit. See meetod tagastab mh userSessionId, mis on vajalik hilisemate autoriseeritud toimingute tegemiseks.

![image](https://user-images.githubusercontent.com/103241074/210289795-43c4e1c1-2e4c-4ef1-b01c-e768183a3460.png)


#

Autoriseeritud raamatukogutöötaja saab:
#
1.Lisadada uusi kasutajaid (profile/register);

2.Otsida kasutajainfot kasutaja perekonnanime järgi (profile/user-info/by/lastName);

3.Otsida kasutajainfot kasutaja id järgi (profile/user-info/by/id);

![image](https://user-images.githubusercontent.com/103241074/210289906-48ab86b9-f3db-4341-a859-9ac3fcc10525.png)

4.Raamatut välja laenutada (library/save/borrow);

5.Võtta raamatut vastu (library/save/borrow-return);

6.Näha raportit tähtajaks tagastamata raamatute kohta (library/get/report/delayed/books);
![image](https://user-images.githubusercontent.com/103241074/210289962-598e9001-50c3-4047-b45c-38f988f9fa27.png)

7.Lisada raamatut (book/add);

![image](https://user-images.githubusercontent.com/103241074/210289989-564c36a6-47a6-4892-837f-adeeecae7caa.png)

8.Otsida raamatut id järgi (book/by/id)

![image](https://user-images.githubusercontent.com/103241074/210290025-50cac7e2-8f49-4632-98f6-d025790ff34e.png)

#

Anonüümne kasutaja saab:

#
1. Otsida raamatuid žanri järgi (book/find/by/genre);

2. Näha kõiki raamatukogus olevaid raamatuid (book/find/all);

3.Otsida raamatuid pealkirja järgi (book/by/title);

![image](https://user-images.githubusercontent.com/103241074/210290051-05ac5f0e-a92c-40d3-a7c2-a854d134b148.png)








