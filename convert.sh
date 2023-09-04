#!/bin/bash

# Считывание .gitmodules файла, чтобы получить пути всех сабмодулей
paths=$(git config --file=.gitmodules --get-regexp path | awk '{print $2}')

for path in $paths; do
    # Деинициализация сабмодуля
    git submodule deinit -f $path

    # Удаление сабмодуля из индекса
    git rm --cached $path

    # Удаление файла .git в сабмодуле
    rm -rf $path/.git

    # Добавление содержимого сабмодуля обратно в индекс
    git add $path
done

# Фиксация изменений
git commit -m "Converted submodules to regular folders"

