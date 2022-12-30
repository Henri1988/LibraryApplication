# LibraryApplication
Projekti struktuur

Projektis saab eristada kahte liiki teenuseid: teenused, mis on seotud konkreetse tabeliga ja teenused, mis on seotud pigem äriloogikaga ja vajavad mitmete andmetabelite poole pöördumist. 

Äriloogika on struktureeritud eraldi library package alla.  Seal asuvasse LibraryService klassi on koondatud näiteks saveBookBorrow meetod, mis omakorda pöördub borrowService ja bookService klasside poole.  Eesmärk on projektis mitte liigselt koormata LibraryService klassi ja seeläbi projekt loetavamaks muuta.
![image](https://user-images.githubusercontent.com/103241074/210113021-6690214c-c5ee-4200-bfa1-0312e6cf99ff.png)
