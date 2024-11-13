REACT NATIVE PROJECT 

Bu doküman, bir React Native projesini sıfırdan kurmak ve çalıştırmak için gerekli adımları ve kurulum bilgilerini içermektedir. Aşağıdaki yönergeleri izleyerek geliştirme ortamınızı kurabilir ve projenizi kolayca çalıştırabilirsiniz. 

1. Node.js Kurulumu
React Native geliştirme ortamını kurmak için önce Node.js'in sisteminize yüklenmesi gerekir. En son sürümü buradan indirip kurabilirsiniz:
🔗 Node.js indir

2. React Native CLI Global Kurulumu
React Native CLI, proje oluşturmak ve yönetmek için kullanılan komut satırı aracıdır. CLI'yı global olarak yüklemek için aşağıdaki komutu çalıştırın:

npm install -g @react-native-community/cli
3. Android Geliştirme Ortamı
Android için uygulama geliştirmek amacıyla gerekli araçların kurulumunu yapmalısınız. Aşağıdaki adımları izleyin:
3.1 Android Studio Kurulumu
Android Studio'yu indirin ve kurun:
🔗 Android Studio indir
3.2 Android Studio Bileşenleri
Kurulum sırasında aşağıdaki bileşenleri seçtiğinizden emin olun:
    • Android SDK
    • Android SDK Platform Tools
    • Android Virtual Device (AVD)
3.3 JDK Yüklemesi
JDK 17 sürümü önerilir. Sisteminizde JDK kurulu değilse, Oracle veya OpenJDK'dan indirerek yükleyin.

4. React Native Proje Oluşturma
Proje dosyalarının bulunduğu dizinden emin olun. Not: Gradle, boşluk karakterleri içeren dizin adlarında hata verebilir. Projeyi oluşturmak için:
Kurulum Komutları
npx @react-native-community/cli init <ProjeAdi>
cd <ProjeAdi>
İşte güncellenmiş doküman, macOS geliştirme ortamı kısmı kaldırılmış olarak:

REACT NATIVE PROJECT SETUP
Bu doküman, bir React Native projesini sıfırdan kurmak ve çalıştırmak için gerekli adımları ve kurulum bilgilerini içermektedir. Aşağıdaki yönergeleri izleyerek geliştirme ortamınızı kurabilir ve projenizi kolayca çalıştırabilirsiniz.

1. Node.js Kurulumu
React Native geliştirme ortamını kurmak için önce Node.js'in sisteminize yüklenmesi gerekir. En son sürümü buradan indirip kurabilirsiniz:
🔗 Node.js indir

2. React Native CLI Global Kurulumu
React Native CLI, proje oluşturmak ve yönetmek için kullanılan komut satırı aracıdır. CLI'yı global olarak yüklemek için aşağıdaki komutu çalıştırın:
npm install -g @react-native-community/cli

3. Android Geliştirme Ortamı
Android için uygulama geliştirmek amacıyla gerekli araçların kurulumunu yapmalısınız. Aşağıdaki adımları izleyin:
3.1 Android Studio Kurulumu
Android Studio'yu indirin ve kurun:
🔗 Android Studio indir
3.2 Android Studio Bileşenleri
Kurulum sırasında aşağıdaki bileşenleri seçtiğinizden emin olun:
    • Android SDK
    • Android SDK Platform Tools
    • Android Virtual Device (AVD)
3.3 JDK Yüklemesi
JDK 17 sürümü önerilir. Sisteminizde JDK kurulu değilse, Oracle veya OpenJDK'dan indirerek yükleyin.

4. React Native Proje Oluşturma
Proje dosyalarının bulunduğu dizinden emin olun. Not: Gradle, boşluk karakterleri içeren dizin adlarında hata verebilir. Projeyi oluşturmak için:
Kurulum Komutları
npx @react-native-community/cli init <ProjeAdi>
cd <ProjeAdi>

5. Varsayılan Dosyaların Temizlenmesi
Birlikte çalışılan projelerde, repodan gelen ve kişisel bilgisayarınıza özgü olmayan dosyaları temizlemek için aşağıdaki delete.bat dosyasını kullanabilirsiniz:
delete.bat İçeriği

rd /s /q .bundle
rd /s /q __tests__
rd /s /q android
rd /s /q ios
del .eslintrc.js
del .gitignore
del .prettierrc.js
del .watchmanconfig
del App.tsx
del Gemfile
del README.md
del app.json
del babel.config.js
del index.js
del jest.config.js
del metro.config.js
del package-lock.json
del package.json
del tsconfig.json
delete.bat dosyasını çalıştırdıktan sonra, projede sadece gerekli ortak dosyalar kalacaktır.
6. Gradle Temizleme ve Uygulamayı Çalıştırma
Android geliştirme sırasında eski veya geçersiz Gradle yapılandırmalarını temizlemek ve ardından projeyi çalıştırmak için şu adımları izleyin:
6.1 Gradle Temizleme

cd android
gradlew.bat clean
cd ..
6.2 Uygulamayı Çalıştırma
React Native projesini çalıştırmak için şu komutu kullanabilirsiniz:

npx react-native run-android

7. Git Komutları
Projenizi bir git reposundan indirip çalıştırmak için aşağıdaki adımları takip edin:
7.1 Reponun Klonlanması

git clone <repository_url>
7.2 Çalışma Dizini Değiştirme

cd <ProjeAdi>
7.3 Bağımlılıkları Kurma
npm install
7.4 Projeyi Çalıştırma
Android için:
npx react-native run-android

Notlar ve Öneriler
    1. Proje dizin isimlerinizde Türkçe karakter veya boşluk kullanmamaya dikkat edin.
    2. Gradle temizliğini düzenli aralıklarla yaparak performans sorunlarını önleyebilirsiniz.

Bu doküman, projenizi hızlı ve etkili bir şekilde kurmanıza yardımcı olmak için hazırlanmıştır. Daha fazla bilgi için React Native resmi belgelerine göz atabilirsiniz:
🔗 React Native Belgeleri 
