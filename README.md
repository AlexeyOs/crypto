# HC-128

## Системные требования
+ ОС Windows XP - Windows 10(так как скрипты написаны для Windows)
+ установленная JDK 1.8 версии и выше


## Установка адатера
+ Для запуска данной программы вам нужно ввести `mvnw clean install` в папке проекта. Так как проект содержит минимальную сборку Maven, то после этой команды автоматически скачаются все библиотеки и соберется исполняемый файл.
+ Запустить скрипт `start.bat`

## Остановка адаптера
+ Запустить скрипт `stop.bat`

## Использование адаптера
1) Ввести абсолютный путь к файлу.
2) Ввести true есть нужно данный файл зашифровать и false если его нужно расшифровать
+ Пример :
    + > D:/tmp/test.xls 
    + Затем нажать Enter
    + > true 
    + Затем нажать Enter
    + Появится сообщение: Success encrypt file: D:/tmp/test.xls
     
    