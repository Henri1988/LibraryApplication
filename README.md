# LibraryApplication
Projekti struktuur

Projektis saab eristada kahte liiki teenuseid: teenused, mis on seotud konkreetse tabeliga ja teenused, mis on seotud pigem äriloogikaga ja vajavad mitmete andmetabelite poole pöördumist. 

Äriloogika on struktureeritud eraldi library package alla.  Seal asuvasse LibraryService klassi on koondatud näiteks saveBookBorrow meetod, mis omakorda pöördub borrowService ja bookService klasside poole.  Eesmärk on projektis mitte liigselt koormata LibraryService klassi ja seeläbi projekt loetavamaks muuta.

Autoriseeritud raamatukogutöötaja saab: 
1.Lisadada uusi kasutajaid (profile/register); 
2.Otsida kasutajainfot kasutaja perekonnanime järgi (profile/user-info/by/lastName);
3.Otsida kasutajainfot kasutaja id järgi (profile/user-info/by/id);

 

4.Raamatut välja laenutada (library/save/borrow);
5.Võtta raamatut vastu (library/save/borrow-return);
6.Näha raportit tähtajaks tagastamata raamatute kohta (library/get/report/delayed/books);

 
7.Lisada raamatut (book/add);
 
8.Otsida raamatut id järgi (book/by/id)


![image](https://user-images.githubusercontent.com/103241074/210288894-b4a9fd5f-bc39-4f6c-bd39-7ecd2c0c61ca.png)

