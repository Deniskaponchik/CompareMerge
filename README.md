## MergeSort
Сортировка слиянием файлов со строковыми или целочисленными массивами
### Для запуска
1. Скачать на компьютер папку [RunMe](https://github.com/Deniskaponchik/CompareMerge/tree/master/RunMe)
2. Должна быть установлена Java на ПК и прописана переменная окружения %JAVA_HOME% для Windows
3.

### Аргументы
| Аргумент                          | Описание |
| ----------------------------------| ---------------------------------------|
| **java -jar**                     | Обязательные аргументы |
| **MergeSort.jar**                 | Имя запускаемой программы              |
| ----------------------------------|----------------------------------------|
| **-a**                            | Не обязательный (по умолчанию сортировка Ascending)|
| **-d**                            | Не обязательный (для выбора сортировки Descending)|
| ----------------------------------|----------------------------------------|
|                                   |Обязательно выбрать тип данных в файлах - либо Строки, либо целые числа|
| **-s str1.txt,str2.txt,int3.txt** | Указание и выбор файлов со строками. Файлы перечисляются через запятую|
| **-i int1.txt,int2.txt,int3.txt** | или Указание и выбор файлов сцелыми чсислами. Файлы перечисляются через запятую|
| ----------------------------------|----------------------------------------|
| **-o result.txt                   | Обязательный. Указание файла для итоговой выгрузки|


### Примеры использования
Для файлов с целыми числами. Сортировка по возрастанию:
![alt text](https://github.com/Deniskaponchik/CompareMerge/blob/master/png/JarIntAsc.PNG)

Для файлов с целыми числами. Сортировка по убыванию:
![alt text](https://github.com/Deniskaponchik/CompareMerge/blob/master/png/JarIntDes.PNG)

Для файлов со строками. Сортировка по возрастанию:
![alt text](https://github.com/Deniskaponchik/CompareMerge/blob/master/png/JarStrAsc.PNG)

Для файлов со строками. Сортировка по убыванию:
![alt text](https://github.com/Deniskaponchik/CompareMerge/blob/master/png/JarStrDes.PNG)

### Реализация
Java 19
[Maven 4.0.0](https://github.com/Deniskaponchik/CompareMerge/blob/master/pom.xml)
* commons-io
* maven-assembly-plugin

