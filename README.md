# LibraryApplication
Projekti struktuur

Projektis saab eristada kahte liiki teenuseid: teenused, mis on seotud konkreetse tabeliga ja teenused, mis on seotud pigem äriloogikaga ja vajavad mitmete andmetabelite poole pöördumist. 

Äriloogika on struktureeritud eraldi library package alla.  Seal asuvasse LibraryService klassi on koondatud näiteks saveBookBorrow meetod, mis omakorda pöördub borrowService ja bookService klasside poole.  Eesmärk on projektis mitte liigselt koormata LibraryService klassi ja seeläbi projekt loetavamaks muuta.

Autoriseeritud raamatukogutöötaja saab:

1.Lisadada uusi kasutajaid (profile/register);

2.Otsida kasutajainfot kasutaja perekonnanime järgi (profile/user-info/by/lastName);

3.Otsida kasutajainfot kasutaja id järgi (profile/user-info/by/id);

![image](https://user-images.githubusercontent.com/103241074/210288932-b3fa5f08-b94d-4000-9a41-c95a837ce62d.png)
4.Raamatut välja laenutada (library/save/borrow);
5.Võtta raamatut vastu (library/save/borrow-return);
6.Näha raportit tähtajaks tagastamata raamatute kohta (library/get/report/delayed/books);

![image](https://user-images.githubusercontent.com/103241074/210288941-2cb6de9b-c010-447d-b56c-29681131c810.png)
7.Lisada raamatut (book/add);

![image](https://user-images.githubusercontent.com/103241074/210288951-d7c1c491-836a-4f48-a96c-4927ce97f766.png)
8.Otsida raamatut id järgi (book/by/id)

![image](https://user-images.githubusercontent.com/103241074/210288957-5842a1bc-f1fb-4485-afb8-6c31f11717a6.png)


