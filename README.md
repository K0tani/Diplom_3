<section class="theory-viewer prisma prisma_theme_light big-theory lesson__homework-theory">
<section class="theory-viewer__blocking-layout-block theory-viewer__block theory-viewer__block_type_vertical-layout theory-viewer__block_layout">
<section class="theory-viewer__block theory-viewer__block_type_markdown">
<div class="Markdown base-markdown base-markdown_with-gallery markdown markdown_size_normal markdown_type_theory full-markdown">
<h1>Задание 3: веб-приложение</h1>
</div>
</section>
<section class="theory-viewer__block theory-viewer__block_type_markdown">
<div class="Markdown base-markdown base-markdown_with-gallery markdown markdown_size_normal markdown_type_theory full-markdown">
<div class="paragraph">В последнем задании тебе нужно протестировать <a href="https://stellarburgers.nomoreparties.site/" target="_blank">веб-приложение Stellar Burgers</a>. </div>
<h3>Что нужно сделать</h3>
<div class="paragraph">Опиши элементы, которые будешь использовать в тестах, с помощью Page Object. </div>
<div class="paragraph">Протестируй функциональность в Google Chrome и Яндекс.Браузере. Подключи Allure-отчёт.</div>
<div class="paragraph">
<strong>Регистрация</strong>
</div>
<div class="paragraph">Проверь:</div>
<ul>
<li>Успешную регистрацию.</li>
<li>Ошибку для некорректного пароля. Минимальный пароль — шесть символов.</li>
</ul>
<div class="paragraph">
<strong>Вход</strong> </div>
<div class="paragraph">Проверь:</div>
<ul>
<li>вход по кнопке «Войти в аккаунт» на главной,</li>
<li>вход через кнопку «Личный кабинет»,</li>
<li>вход через кнопку в форме регистрации,</li>
<li>вход через кнопку в форме восстановления пароля.</li>
</ul>
<div class="paragraph">
<strong>Переход в личный кабинет</strong> </div>
<div class="paragraph">Проверь переход по клику на «Личный кабинет».</div>
<div class="paragraph">
<strong>Переход из личного кабинета в конструктор</strong> </div>
<div class="paragraph">Проверь переход по клику на «Конструктор» и на логотип Stellar Burgers.</div>
<div class="paragraph">
<strong>Выход из аккаунта</strong>
</div>
<div class="paragraph">Проверь выход по кнопке «Выйти» в личном кабинете.</div>
<div class="paragraph">
<strong>Раздел «Конструктор»</strong>
</div>
<div class="paragraph">Проверь, что работают переходы к разделам:</div>
<ul>
<li>«Булки»,</li>
<li>«Соусы»,</li>
<li>«Начинки».</li>
</ul>
<h3>Как выполнить и сдать работу</h3>
<div class="paragraph">Напиши код в IDEA и запушь ветку <code class="code-inline code-inline_theme_light">develop3</code> на GitHub. Сделай пул-реквест. 
<a href="https://code.s3.yandex.net/qa-automation-engineer/java/cheatsheets/paid-track/diplom/upload-tasks-2-and-3.pdf" target="_blank">Подробная инструкция</a>.</div>
<h3>Как будут оценивать твою работу</h3>
<ol start="1">
<li>Тесты в <code class="code-inline code-inline_theme_light">test/java</code>.</li>
<li>Для Page Object создан отдельный пакет.</li>
<li>Для каждой страницы создан отдельный класс с Page Object.</li>
<li>Тесты разделены по тематике или функциональности. Для тестов созданы отдельные классы.</li>
<li>В файле <code class="code-inline code-inline_theme_light">pom.xml</code> нет ничего лишнего.</li>
<li>Все элементы страниц, которые ты используешь в тестах, описаны в Page Object.</li>
<li>Название класса Page Object отражает его содержимое.</li>
<li>Названия локаторов понятны.</li>
<li>Тесты запускаются и не падают.</li>
<li>Названия тестов понятные и неизбыточные.</li>
<li>Тест — прежде всего проверка, а не набор действий. Каждый тест что-то проверяет.</li>
<li>Нужные тестовые данные создаются перед тестом и удаляются после того, как он выполнится.</li>
<li>Есть все тесты, которые описаны в задании.</li>
<li>Сделан Allure-отчёт. Отчёт добавлен в пул-реквест.</li>
<li>В проекте используется Java 11.</li>
</ol>
</div>
</section>
</section>
</section>