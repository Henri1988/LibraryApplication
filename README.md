# LibraryApplication
Projekti struktuur

Projektis saab eristada kahte liiki teenuseid: teenused, mis on seotud konkreetse tabeliga ja teenused, mis on seotud pigem äriloogikaga ja vajavad mitmete andmetabelite poole pöördumist. 

Äriloogika on struktureeritud eraldi library package alla.  Seal asuvasse LibraryService klassi on koondatud näiteks saveBookBorrow meetod, mis omakorda pöördub borrowService ja bookService klasside poole.  Eesmärk on projektis mitte liigselt koormata LibraryService klassi ja seeläbi projekt loetavamaks muuta.
