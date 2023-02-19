## MergeSort
Сортировка слиянием файлов со строковыми или целочисленными массивами
### Для запуска
1. Скачать на компьютер папку [RunMe](https://github.com/Deniskaponchik/CompareMerge/tree/master/RunMe)
2. Должна быть установлена [Java SE Development Kit 19.0.2](https://www.oracle.com/java/technologies/downloads/#java19) на компьютере
3. Перезагрузиться
4. Перейти в командной строке в скачанную папку.


### Аргументы
| Аргумент                          | Описание |
| ----------------------------------| ---------------------------------------|
| **java -jar**                     | Обязательные аргументы |
| **MergeSort.jar**                 | Имя запускаемой программы              |
| ----------------------------------|----------------------------------------|
| **-a**                            | Не обязательный (по умолчанию сортировка Ascending)|
| **-d**                            | Не обязательный (для выбора сортировки Descending)|
| ----------------------------------|----------------------------------------|
|                                   | Обязательно выбрать тип данных в файлах: либо Строки (-s), либо целые числа (-i)|
| **-s str1.txt,str2.txt,int3.txt** | Указание и выбор файлов со строками. Файлы перечисляются СРАЗУ после аргумента (-s) через ЗАПЯТУЮ |
| **-i int1.txt,int2.txt,int3.txt** | или Указание и выбор файлов сцелыми числами. Файлы перечисляются СРАЗУ после аргумента (-i) через ЗАПЯТУЮ |
| ----------------------------------|----------------------------------------|
| **-o result.txt**                 | Обязательный. Указание файла для итоговой выгрузки|


### Примеры использования

Версия java <br />
![Версия java](https://github.com/Deniskaponchik/CompareMerge/blob/master/png/JavaVersion.PNG)

Для файлов с целыми числами. Сортировка по возрастанию:
![alt text](https://github.com/Deniskaponchik/CompareMerge/blob/master/png/JarIntAsc.PNG)

Для файлов с целыми числами. Сортировка по убыванию:
![alt text](https://github.com/Deniskaponchik/CompareMerge/blob/master/png/JarIntDes.PNG)

Для файлов со строками. Сортировка по возрастанию: <br />
![alt text](https://github.com/Deniskaponchik/CompareMerge/blob/master/png/JarStrAsc.png)

Для файлов со строками. Сортировка по убыванию:
![alt text](https://github.com/Deniskaponchik/CompareMerge/blob/master/png/JarStrDes.PNG)

### Реализация
[Java 19.0.2](https://www.oracle.com/java/technologies/downloads/#java19) <br />
[Maven 4.0.0](https://github.com/Deniskaponchik/CompareMerge/blob/master/pom.xml)
* commons-io
* maven-assembly-plugin

