Задание: Работа с синхронизацией. Synchronization, wait, notify, sleep, lock
Курс: Многопоточное и функциональное программирование

Здравствуйте, Дмитрий!
Спасибо за Ваше решение!

Есть нюансы в вашей работе.
1) статик потерялся?
2) https://github.com/ziDmitryE/Autosalon/commit/f0a41be69d12c98c381847276e6bd76aca89d1a5#diff-61a8ca0e8e14ae40d4c786a80b30f11a2ecae351aca9d61458e60014ca364a84R25 - чего именно тут ждем?
3) https://github.com/ziDmitryE/Autosalon/commit/f0a41be69d12c98c381847276e6bd76aca89d1a5#diff-61a8ca0e8e14ae40d4c786a80b30f11a2ecae351aca9d61458e60014ca364a84R43 - назовите переменную так, чтоб было понятно, что ждем оформления авто (покупку)
4) В корне репозитория должны быть только src, build.gradle и .gitignore. Добавьте гитигнор и уберите лишнее

Если что-то непонятно, не стесняйтесь, задавайте вопросы.
Успехов
_________________________________________________________________

Здравствуйте, Дмитрий!
Спасибо за Ваши доработки!

Есть нюансы в вашей работе.
1) https://github.com/ziDmitryE/Autosalon/blob/main/src/main/java/Maker.java#L12-L13 - вот тут вряд ли статик
2) https://github.com/ziDmitryE/Autosalon/blob/main/src/main/java/Maker.java#L14-L15 - тут верные модификаторы, но неверное имя. Константы именуются немного иначе
3) https://github.com/ziDmitryE/Autosalon/blob/main/src/main/java/Maker.java#L24 - а зачем мы в критической секции машину собираем? Кажется, что сборка авто проходит на мощностях завода, а не в автосалоне, нам не нужен доступ к общим ресурсам тут

Остальные исправления отлично!
