package tests.Basket;

import lib.BaseClass.BaseTestClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.GoodsListPage;
import pages.MainPage;

/**
 * Логика теста заключается в том, что тест идёт на главную страницу,
 * Затем находит строку поиска
 * Заполняет её названием товара
 * Переходит на страницу списка товаров в каталоге
 * Получает список товаров отображаемых на странице
 * Собирает данные о первом в списке товаре
 * Переходит на страницу этого товара
 * Проверяет соответствие данных внутри страницы и тех, что были собраны в общем списке
 * Добавляет товар в корзину
 * Проверяет информацию о товаре в открышемся поп-апе
 * Закрывает поп-ап - проверяет, что состояние корзины отлично от пусой
 * Снова открывает корзину - проверяет информацию о товаре в поп-апе
 */


public class AddGoodFromGoodsPageCatalog extends BaseTestClass{

    private static MainPage mainPage;
    private static GoodsListPage goodsPage;

    @BeforeClass
    public static void beforeClassMethod(){
        mainPage = new MainPage(webDriver);
    }

    @Test
    public void testAddGoodFromGoodsPageCatalog(){
        mainPage.searchingGoodByName("Плойка");
        goodsPage = mainPage.goodsListPage();
        goodsPage.openFirstGoodFromList();
    }


}
