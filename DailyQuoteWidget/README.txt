# Daily Quote Widget  

# Overview  
An Android home screen widget that displays a **random motivational quote** from a predefined list of **20+ quotes**. When the user taps the widget, it updates with a **new random quote**. The widget is **visually appealing** and **resizable**.  

---

# Features  
-  **Random Motivational Quotes** → Displays a new quote every time the widget is tapped.  
-  **Predefined List of Quotes** → Includes at least 20 motivational quotes with author names.  
-  **Resizable Widget** → Can be resized to fit different screen spaces.  
-  **Visually Appealing Design** → Uses a colorful background and clean typography.  

---

# Technologies Used  
- **Kotlin** → Primary language for Android development.  
- **Android SDK 34** → Target SDK: 34 | Minimum SDK: 21  
- **AppWidgetProvider** → Manages widget lifecycle and updates.  
- **RemoteViews** → Updates widget UI dynamically.  

---

# How I Built This  
1. **Designed the Widget Layout** using `widget_layout.xml` with text styling and a colorful background.  
2. **Implemented Random Quote Selection** using a predefined list in `QuoteWidget.kt`.  
3. **Handled Click Events** to refresh the quote when the widget is tapped.  
4. **Ensured Compatibility** with different Android versions by using appropriate `PendingIntent` flags.  

---

### Installation & Usage  


# Prerequisites  
- Install **Android Studio (Latest Version)**  
- Ensure **Android SDK 34** is installed  
- Use a device/emulator running **Android 5.0+ (API 21+)**  

# Steps to Run  
1. **Clone or Extract the Project**  
   - If received as a ZIP file, extract it.  
2. **Open the Project in Android Studio**  
   - Open **Android Studio** → Click on **Open** → Select the project folder.  
3. **Build and Run the Project**  
   - Ensure Gradle dependencies are up to date.  
   - Connect a device or start an emulator.  
   - Click **Run** (▶) to install and launch.  
4. **Add the Widget to Home Screen**  
   - Long-press on the home screen.  
   - Select **Widgets**.  
   - Find **Daily Quote Widget** and drag it onto the home screen.  
5. **Tap the Widget** to update the quote!  

---


