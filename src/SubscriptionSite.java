public class SubscriptionSite {
   public static void main(String[] args) {
      User[] readers = {
         new Guest(),
         new Member("登録会員Ａ"),
         new PaidMember("有料会員Ｂ")
      };
      Article.create("ØØØ1", "PC入門", "PC初心者…", true);
      Article.create("ØØØ2", "スマホ特集", "最新のスマホ…", false);
      Article.create("ØØØ3", "アプリガイド", "使えるアプリ …", true);
      for (User reader : readers) {
         for (String id : Article.getIds()) {
            Article article = Article.getArticle(id);
            String body;
            if (reader.testAndMark(article)) {
               body = article.getBody();
            } else {
               body = "＜閲覧不可＞";
            }
            System.out.printf("%s: 記事「%s」%s%n", reader.getName(), article.getHeadline(), body);
         }
      }
   }
}