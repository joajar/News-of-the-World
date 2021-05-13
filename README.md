
# News-Of-The-World-App

W tym repo można znaleźć aplikację, która:
<ul>
<li>
wykorzystuje publiczne API <a href="https://newsapi.org">newsapi.org</a>, pobierając zeń artykuły w kategorii business, dla kraju Polska
</li>
<li>
zapisuje pobierane artykuły we wskazanym pliku tekstowym zgodnie z poniższym formatem:

title:description:author

title:description:author
</li>
<li>
zawiera interfejs graficzny wykonany w Thymeleaf
</li>
<li>
plik z newsami zapisywany jest w lokalizacji ustalonej w formularzu we froncie aplikacji: można albo wykorzystać proponowaną lokalizację, albo ją zmienić
</li>
</ul>

Krótki filmik z demostracją działania przygotowanej aplikacji można obejrzeć 
<a href="https://www.youtube.com/watch?v=gUiMpChVW08">na YouTube'ie (klik!)</a>

TODO:
<ul>
<li>
testy jednostkowe
</li>
<li>
uporządkowanie frontu, m.in. css-ów
</li>
<li>
dopracowanie struktury kodu (m.in. usunięcie metod statycznych - zamiast nich pełne wykorzystanie OOP)
</li>
<li>
dodanie pełnej obsługi wyjątków: obecnie obsługiwana jest jedynie sytuacja, gdy podana lokalizacja zawiera już plik o wybranej nazwie
</li>
<li>
sprawdzenie, jak aplikacja działa pod Windowsem (aplikacja została stworzona w Linuxie i tylko tam zostało sprawdzone jej działanie)
</li>
</ul>