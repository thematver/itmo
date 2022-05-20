Вариант 12800.

Скачаем все “коммиты” и запакуем их в zip.
Затем на Helios создадим папку msp и распакуем туда наш архив.

`mkdir msp && unzip commits.zip -d msp`

# Для Git

    git config --global user.email "one@example.com"
    git config --global user.name "Mr. One"

Затем:

    mkdir git && cp commit0/* git && cd git && git init . &&  git add . && git commit -m "r0"

Таким образом появится коммит `r0` в репозитории.

Теперь сделаем ветку `dev` (нижняя на графике).

    git branch dev
    
Сделаем коммит `r1`.

    yes | cp -rf ../commit1/* . && git add . && git commit -m "r1"
   
Создадим ветку `feature` (синяя)
    
    git branch feature
    
Сделаем коммиты `r2`, `r3`.

    yes | cp -rf ../commit2/* . && git add . && git commit -m "r2"
    yes | cp -rf ../commit3/* . && git add . && git commit -m "r3"
    
Теперь вернемся к ветке `master`
    
    git checkout master

Сделаем коммиты `r4`, `r5`.

    yes | cp -rf ../commit4/* . && git add . && git commit -m "r4"
    yes | cp -rf ../commit5/* . && git add . && git commit -m "r5"

Вернемся к `dev`. 

    git checkout dev
    
Сделаем коммит `r6`.

    yes | cp -rf ../commit6/* . && git add . && git commit -m "r6"
    
Перейдем к `feature`.
    
    git checkout feature
    
Сделаем коммит `r7`.

    yes | cp -rf ../commit7/* . && git add . && git commit -m "r7"
    
Перейдем к `master`.

    git checkout master
 
И сделаем коммит `r8`.

    yes | cp -rf ../commit8/* . && git add . && git commit -m "r8"
    
Перейдем к `feature`.
    
    git checkout feature
    
Сделаем коммит `r9`.

    yes | cp -rf ../commit9/* . && git add . && git commit -m "r9"
    
Перейдем к `dev`.
    
    git checkout dev
    
Сделаем коммит `r10`.

    yes | cp -rf ../commit10/* . && git add . && git commit -m "r10"
    
Перейдем к `feature`.
    
    git checkout feature
    
Сделаем коммит `r11`.

    yes | cp -rf ../commit11/* . && git add . && git commit -m "r11"
    
Перейдем к `dev`.

    git checkout dev

Перенесем файлы из `commit12` в наш репозиторий.

    yes | cp -rf ../commit12/* . && git add . && git commit -m "r12"
    
Смержим ветки `dev` и `feature`.

    git merge feature
    
Получаем конфликт. Решаем его. В C.java отсутствуют некоторые методы в одной из версий. Можно, например, оставить их.

Сделаем коммит `r13`.

    yes | cp -rf ../commit13/* .  && git add . && git commit -m "r13"
    
Переключаемся на `master`.
    
    git checkout master
    
Сделаем коммит `r14`.

    yes | cp -rf ../commit14/* .  && git add . && git commit -m "r14"
    
Смержим `dev` и `master`.

    get merge dev
   
Опять конфликт. Решаем его.

 # Для SVN

    mkdir svn
    svnadmin create repo
    cd svn
    svn import home/s311716/msp/svn/work file:///home/s311716/msp/svn/repo/trunk -m “Init trunk”
    svn co file:///home/s311716/msp/svn/repo/trunk file://$HOME/.svnrepos/MyRepo/tags
    svn add *
    svn ci -m r0
    
    cp ../commit0/* . && svn add * && svn commit -m "r0"
    svn cp --parents file:///home/s311716/msp/svn/repo/trunk file:///home/s311716/msp/svn/repo/branches/dev -m "Init dev"
    yes | cp -rf ../commit1/* . 
    svn co file:///home/s311716/msp/svn/repo/trunk
    svn add * --force
    svn ci -m r1
    
    
    svn cp --parents file:///home/s311716/msp/svn/repo/trunk file:///home/s311716/msp/svn/repo/branches/feauture -m "Init feature"
    yes | cp -rf ../commit2/* . 
    svn co file:///home/s311716/msp/svn/repo/branches/feature
    svn add *
    svn ci -m r2
    
    yes | cp -rf ../commit3/* . && svn add * && svn ci -m r3
    
    svn sw file:///home/s311716/msp/svn/repo/branches/trunk
    yes | cp -rf ../commit4/* . && svn add * && svn ci -m "r4"
    yes | cp -rf ../commit5/* . && svn add * && svn ci -m "r5"
    svn sw file:///home/s311716/msp/svn/repo/branches/dev
    yes | cp -rf ../commit6/* . && svn add * && svn ci -m "r6"
    svn sw file:///home/s311716/msp/svn/repo/branches/feature
    yes | cp -rf ../commit7/* . && svn add * && svn ci -m"r7"
    svn sw file:///home/s311716/msp/svn/repo/branches/master
    yes | cp -rf ../commit8/* . && svn add * && svn ci -m "r8"
    svn sw file:///home/s311716/msp/svn/repo/branches/feature
    yes | cp -rf ../commit9/* . && svn add * && svn ci -m "r9"
    svn sw file:///home/s311716/msp/svn/repo/branches/dev
    yes | cp -rf ../commit10/* . && svn add * && svn ci -m "r10"
    svn sw file:///home/s311716/msp/svn/repo/branches/feature
    yes | cp -rf ../commit11/* . && svn add * && svn ci -m "r11"
    svn sw file:///home/s311716/msp/svn/repo/branches/dev
    yes | cp -rf ../commit12/* . && svn add *
    svn merge file:///home/s311716/msp/svn/repo/branches/feature
    
Получаем конфликт. Решаем его.

    svn up
    svn resolved
    svn add *
    svn ci -m r12
    
    yes | cp -rf ../commit13/* .  && svn add * && svn ci -m "r13"
    svn sw file:///home/s311716/msp/svn/repo/branches/master
    yes | cp -rf ../commit14/* .  && svn add *
    svn sw file:///home/s311716/msp/svn/repo/branches/dev
  
 Решаем конфликт.
 
    svn up
    svn resolved
    svn add *
    svn ci -m r14

 



