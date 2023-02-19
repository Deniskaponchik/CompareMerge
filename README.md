[comment]: <> (https://dillinger.io/)
[comment]: <> (https://cloudconvert.com/save-website-pdf)
## MergeSort
Сортировка слиянием файлов со строковыми или целочисленными массивами
### Вариант запуска №1 (с установкой Java)
1. Должна быть установлена [Java SE Development Kit 19.0.2](https://www.oracle.com/java/technologies/downloads/#java19) на компьютере. 
2. Прописана переменная окружения. Для Windows это %JAVA_HOME%
3. Перезагрузиться
4. Скачать на компьютер папку [RunMe](https://github.com/Deniskaponchik/CompareMerge/tree/master/RunMe)
5. Перейти в командной строке в скачанную папку.

Версия java <br />
![java -version](https://github.com/Deniskaponchik/CompareMerge/blob/master/png/JavaVersion.PNG)
Переменная окружения <br />
![java -version](https://github.com/Deniskaponchik/CompareMerge/blob/master/png/JavaHome.PNG)

### Вариант запуска №2 (Без установки Java)
GitHub не даёт заливать файлы больше 100мб в проект. Проект со вложенным окружением JRE, где всё включено и ничего не нужно устанавливать, выложил [сюда](https://mega.nz/folder/0TYx2T6R#b4HKkgXknJ0QG7lsHc3fDQ)

### Аргументы
| Аргумент                        | Описание |
| -------------------------------| ---------------------------------------|
| **java -jar MergeSort.jar**     | Для запуска jar файла                  |
| или                             |                                        |
| **MergeSort.exe**               | Или для запуска exe                    |
| -------------------------------|----------------------------------------|
| **-a**                            | Не обязательный (по умолчанию сортировка Ascending)|
| или                               |                                                    |
| **-d**                            | Не обязательный (для выбора сортировки Descending) |
| -------------------------------|----------------------------------------|
|                                   | Обязательно выбрать тип данных в файлах: либо Строки (-s), либо целые числа (-i)|
| **-s str1.txt,str2.txt,int3.txt** | Указание и выбор файлов со строками. Файлы перечисляются СРАЗУ после аргумента (-s) через ЗАПЯТУЮ |
| или                               |                                                                   |
| **-i int1.txt,int2.txt,int3.txt** | или Указание и выбор файлов сцелыми числами. Файлы перечисляются СРАЗУ после аргумента (-i) через ЗАПЯТУЮ |
| -------------------------------|----------------------------------------|
| **-o result.txt**                 | Обязательный. Указание файла для итоговой выгрузки|


### Примеры использования

Для входных файлов с целыми числами. Сортировка по возрастанию. <br />
jar в случае ошибок с входными данными - покажет ошибку: <br />
![java -jar MergeSort.jar -a -i int1.txt,int2.txt,int3.txt -o result.txt](https://github.com/Deniskaponchik/CompareMerge/blob/master/png/JarIntAsc.PNG)

Для входных файлов с целыми числами. Сортировка по убыванию. <br />
jar в случае ошибок с входными данными - покажет ошибку: <br />
![java -jar MergeSort.jar -d -i int1.txt,int2.txt,int3.txt -o result.txt](https://github.com/Deniskaponchik/CompareMerge/blob/master/png/JarIntDes.PNG)

Для входных файлов с целыми числами. Сортировка по убыванию. <br />
exe в случае ошибок с входными данными ошибок не выведет: <br />
![MergeSort.exe -d -i int1.txt,int2.txt,int3.txt -o result.txt](https://github.com/Deniskaponchik/CompareMerge/blob/master/png/ExeIntDes.PNG)

Для входных файлов со строками. Сортировка по возрастанию. <br />
jar в случае ошибок с входными данными - покажет ошибку: <br />
![java -jar MergeSort.jar -a -s str1.txt,str2.txt,str3.txt -o result.txt](https://github.com/Deniskaponchik/CompareMerge/blob/master/png/JarStrAsc.png)

Для входных файлов со строками. Сортировка по убыванию. <br /> 
jar в случае ошибок с входными данными - покажет ошибку: <br />
![java -jar MergeSort.jar -d -s str1.txt,str2.txt,str3.txt -o result.txt](https://github.com/Deniskaponchik/CompareMerge/blob/master/png/JarStrDes.PNG)

Для входных файлов со строками. Сортировка по убыванию. <br />
exe в случае ошибок с входными данными ошибок не выведет: <br />
![MergeSort.exe -d -s str1.txt,str2.txt,str3.txt -o result.txt](https://github.com/Deniskaponchik/CompareMerge/blob/master/png/ExeStrDes.PNG)


### Реализация
[Java 19.0.2](https://www.oracle.com/java/technologies/downloads/#java19) <br />
[Maven 4.0.0](https://github.com/Deniskaponchik/CompareMerge/blob/master/pom.xml)
* commons-io
* commons-cli
* [maven-assembly-plugin](https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-assembly-plugin)
* [launch4j-maven-plugin](https://mvnrepository.com/artifact/com.akathist.maven.plugins.launch4j/launch4j-maven-plugin)

