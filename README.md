<h1 style="text-align: left; display: flex;">
  <img src="https://raw.githubusercontent.com/Melikash98/BrewBiteApp/main/logoApp.png" alt="Logo" width="80px"   height="80px" style="margin-right: 10px;padding-top: 6rem;" />
BrewBite
</h1>

[![](https://jitpack.io/v/Melikash98/MorphNavBar.svg)](https://jitpack.io/#Melikash98/MorphNavBar)
[![Cloudinary](https://img.shields.io/badge/Cloudinary-3.1.2-007ACC?style=flat&logo=cloudinary&logoColor=white)](https://github.com/cloudinary/cloudinary_android)
[![CircleImageView](https://img.shields.io/badge/CircleImageView-3.1.0-34A853?style=flat&logo=android)](https://github.com/hdodenhof/CircleImageView)
[![Glide](https://img.shields.io/badge/Glide-5.0.5-00BCD4?style=flat&logo=glide)](https://github.com/bumptech/glide)
[![Retrofit](https://img.shields.io/badge/Retrofit-3.0.0-9C27B0?style=flat)](https://github.com/square/retrofit)
[![Shimmer](https://img.shields.io/badge/Shimmer-0.5.0-2196F3?style=flat)](https://github.com/facebook/shimmer-android)
[![Android GIF Drawable](https://img.shields.io/badge/GIF_Drawable-1.2.31-FF5722?style=flat)](https://github.com/koral--/android-gif-drawable)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Java](https://img.shields.io/badge/Java-11+-ED8B00?style=flat&logo=openjdk&logoColor=white)](https://www.java.com)
[![Firebase](https://img.shields.io/badge/Firebase-FFCA28?style=flat&logo=firebase&logoColor=black)](https://firebase.google.com)
[![Android](https://img.shields.io/badge/Android-3DDC84?style=flat&logo=android&logoColor=white)](https://developer.android.com)
[![GitHub](https://img.shields.io/badge/GitHub-Repository-181717?style=flat&logo=github)](https://github.com/Melikash98/Haus-Suche)


<img src="https://raw.githubusercontent.com/Melikash98/BrewBiteApp/main/app_video.gif" alt="Logo" width="100%"   height="100%" style="margin-right: 10px;padding-top: 6rem;" />
##<p align="left" width="100%">
  Fresh flavors, cozy moments, and a smarter way to enjoy your daily brew.
</p>


---
<p align="left">
  <a href="#features">Features</a><br>
   <a href="#tech-stack">Tech Stack</a><br>
  <a href="#contributing">Contributing</a><br>
   <a href="#license">License</a><br>
</p>


---

## Overview

**BrewBite** is a full-featured Android ordering app for cafés and bakeries,
covering the complete user journey — from browsing a live menu to online payment.

The project serves a dual purpose: it is a **production-grade portfolio app**
and a real-world test bench for two custom open-source Android libraries
authored alongside it — [MorphNavBar]([#](https://github.com/Melikash98/MorphNavBar)) and [Editify]([#](https://github.com/Melikash98/Editify)) — both consumed here
as dependencies, exactly as any third-party library would be.

Rather than mocking payments or stubbing network calls, BrewBite integrates
real services end-to-end: Firebase for auth and live data sync, Cloudinary
for image upload and storage, and PayPal + Google Pay via their official SDKs.

The catalog is split into two distinct item categories (café drinks and bakery
goods), each rendered in both a grid view and a list view depending on context.
User sessions, favourites, order history, and profile data all persist in
Firestore in real time.

This repository is intended as a reference for junior-to-mid Android developers
who want to see how auth flows, cloud storage, payment SDKs, and custom UI
libraries fit together in a single coherent project.

---
> **Android 7.0 (API 24) → latest** &nbsp;|&nbsp; **Java** &nbsp;|&nbsp;
> **Firebase** &nbsp;|&nbsp; **Cloudinary** &nbsp;|&nbsp; **PayPal · Google Pay**
---

## Features <a name="features"></a>
**Authentication & Account**
- Register, sign in, and reset password with real-time field validation via Editify.
- Full profile editing — name, username, avatar (Cloudinary), gender, location, phone, birthday.
- Account deletion with confirmation dialog; all data removed from Firestore instantly.

**Catalog & Discovery**
- Two independent item categories: café drinks and bakery goods.
- Grid and list layouts that switch automatically based on context.
- Per-item customisation — size, sugar, and ice for drinks; weight and toppings for bakery items.
- Real-time search and one-tap favourites, synced instantly to the user profile.

**Cart & Checkout**
- Quantity controls, discount code input, and a live price breakdown (subtotal, delivery, tax).
- PayPal and Google Pay via official SDKs — payment completes without leaving the app.

**Backend & Media**
- Firebase Firestore for real-time data sync across all screens.
- Firebase Auth for session management and secure account deletion.
- Cloudinary for image upload and delivery.
- Glide for fast image loading and caching from Cloudinary URLs.

**Custom Libraries**
- [MorphNavBar]([#](https://github.com/Melikash98/MorphNavBar)) — animated bottom nav with a morphing active indicator.
- [Editify]([#](https://github.com/Melikash98/Editify)) — smart input field with icon support, focus states, and password toggle.

Both libraries target Android 7.0+ and were battle-tested inside BrewBite before release.

---

## Tech Stack <a name="tech-stack"></a>
| Layer | Technology |
|---|---|
| Language | Java 11+ |
| Min SDK | Android 7.0 (API 24) |
| Backend & Auth | Firebase Firestore · Firebase Authentication |
| Image Storage | Cloudinary Android SDK |
| Payments | PayPal Mobile SDK · Google Pay API |
| Navigation | MorphNavBar *(custom — [view repo](#))* |
| Input Components | Editify *(custom — [view repo](#))* |
| Image Loading | Glide |
| Architecture | Single-activity, fragment-based |

> Service credentials (`google-services.json`, Cloudinary API key, PayPal client ID)
> are excluded from the repository. See [Setup](#setup) for configuration steps.

---

## License <a name="license"></a>

<p align="left" width="100%">
 This project is licensed under the **MIT License** — perfect for portfolio and demo projects.
 See the [LICENSE](https://github.com/Melikash98/Haus-Suche/blob/main/LICENSE) file for full details.
</p>

---

## ⭐ Show Your Support

If you like this project and find it useful for your learning or portfolio:

- Give it a **Star** ⭐ on GitHub  
- Share it with your friends or on LinkedIn  
- Open an issue or suggest new features  

**Feedback is always welcome!** Feel free to contact me for any questions or collaboration ideas.

---
Made with ❤️ for the Android community.
