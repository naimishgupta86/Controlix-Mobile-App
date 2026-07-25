📱 Controlix Mobile App

Controlix ek Android utility application hai jo multiple device features ko ek hi platform se control karne ke liye design ki gayi hai.
App ka main focus hai simplicity, performance aur real-time control.

---

🚀 Features

🔐 Authentication System

- Register & Login options
- Online / Offline mode selection

🗄️ Real-Time Database Entry

- User details input (Name, Email, Mobile, Address)
- Data submission functionality

⚙️ System Services

- 📶 WiFi Control
- 🔵 Bluetooth Control
- 🔦 Torch (Flashlight)
- 📳 Vibrator Control
- 🎵 Music Access
- 🗣️ Text-to-Speech
- 🌐 Browser Launch

📱 Application Services

- 🎮 Quiz Game
- ❌⭕ Tic Tac Toe Game

🎛️ User Interface

- Clean & modern UI design
- Button-based navigation
- Fast and responsive performance

---

🛠️ Tech Stack

- Language: Java
- IDE: Android Studio
- UI: XML Layouts
- APIs Used:
  - WifiManager
  - BluetoothAdapter
  - CameraManager
  - TextToSpeech
  - Intent System

---

📂 Project Structure

Controlix-Mobile-App/
│── app/
│   ├── java/com/example/controlix/
│   │   └── Activities (Login, Register, Services, etc.)
│   ├── res/
│   │   ├── layout/
│   │   ├── drawable/
│   │   └── values/
│   └── AndroidManifest.xml

---

🔐 Permissions Used

<uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>
<uses-permission android:name="android.permission.CHANGE_WIFI_STATE"/>
<uses-permission android:name="android.permission.BLUETOOTH"/>
<uses-permission android:name="android.permission.BLUETOOTH_ADMIN"/>
<uses-permission android:name="android.permission.CAMERA"/>
<uses-permission android:name="android.permission.VIBRATE"/>
<uses-permission android:name="android.permission.INTERNET"/>

---

⚙️ Installation

git clone https://github.com/naimishgupta86/Controlix-Mobile-App.git

1. Open project in Android Studio
2. Sync Gradle
3. Run on emulator or physical device

---

⚠️ Notes

- Android 10+ me kuch system controls restricted ho sakte hain
- Bluetooth aur WiFi ke liye runtime permissions required hote hain
- Torch feature device hardware par depend karta hai

---

💡 Future Improvements

- 🌙 Dark Mode
- 📊 Dashboard for system status
- 🔒 Secure authentication system
- ☁️ Cloud database integration

---

👨‍💻 Developer

Naimish Gupta

---


---

📄 License

This project is free to use for learning purposes.
