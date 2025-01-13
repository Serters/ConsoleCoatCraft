<div align="center">
  <img src="https://github.com/Serters/ConsoleCoatCraft/blob/main/console-coat-craft/src/main/resources/readme/webps/banner.webp" alt="ConsoleCoatCraft" width="100%">
</div>

<div align="center">

![Static Badge](https://img.shields.io/badge/ConsoleCoatCraft-blue?label=Cyberdark&labelColor=%2386FFCA&color=%23523B27)
![GitHub contributors](https://img.shields.io/github/contributors/Serters/ConsoleCoatCraft)
![GitHub top language](https://img.shields.io/github/languages/top/Serters/ConsoleCoatCraft)
![GitHub Repo stars](https://img.shields.io/github/stars/Serters/ConsoleCoatCraft)

</div>

## Key Features

1. **Flag Generation**: Generate flags with customizable dimensions, colors, and designs.
2. **Coat of Arms**: Incorporate coat of arms patterns into flags with various sizes and positions.
3. **Multiple Flag Types**: Create horizontal, vertical, and plain flags to suit different design preferences.
4. **Color Customization**: Choose from a wide range of colors for both flag backgrounds and coat of arms, if non fit you can add your own!
5. **Rendering Options**: Render flags and coat of arms patterns for display or further processing.

## Examples

1. **Horizontal FlagV**:
```java
CoatOfArms fox = new CoatOfArms(26, "Fox", "Black", "center", "middle")

HorizontalFkag horizontalFlag = new HorizontalFkag(62, 32, fox, "orange", "black", "white", "orange " orange", "white", "black", "orange")

horizontalFlag.display();
```
<div align="center">
  <img src="https://github.com/Serters/ConsoleCoatCraft/blob/main/console-coat-craft/src/main/resources/readme/webps/horizontalFlag_example_display.webp" width="100%">
</div>

---

2. **Vertical Flag**:
```java
CoatOfArms dolphin = new CoatOfArms(26, "Dolphin", "Yellow", "center", "middle")

VerticalFlag verticalFlag = new VerticalFlag (62, 32, dolphin, "Black", "Yellow")

verticalFlag.display()
```
<div align="center">
  <img src="https://github.com/Serters/ConsoleCoatCraft/blob/main/console-coat-craft/src/main/resources/readme/webps/verticalFlag_example_display.webp" width="100%">
</div>

---
CoatOfArms fox = new CoatOfArms(26, "Dolphin", yellow", "left", "middle")


```java
NordicCrossFlag ncf = new NordicCrossFlag(72, 46, "red", "blue", "white");
ncf.display();

```

<div align="center">
  <img src="https://github.com/Serters/ConsoleCoatCraft/blob/main/console-coat-craft/src/main/resources/readme/NordicFlag_example_display.png" width="100%">
</div>

3. **Nordic Cross Flag**

## UML class diagram

<div align="center">
  <img src="https://github.com/Serters/ConsoleCoatCraft/blob/main/console-coat-craft/src/main/resources/readme/webps/uml_class_diagram.webp" alt="uml class diagram" width="100%">
</div>

## Code

1. **CoatOfArms.generate()**: Generates the coat of arms pattern as an array of strings. Each string represents a row in the pattern, with characters representing the coat of arms symbol or background. The method reads the symbol image associated with the coat of arms, resizes it to the specified size, and converts it into a pattern of characters representing the image pixels. Each pixel is represented by two characters: "██" for non-transparent pixels and " " for transparent pixels.

<div align="center">
  <img src="https://github.com/Serters/ConsoleCoatCraft/blob/main/console-coat-craft/src/main/resources/readme/webps/CoatOfArms_generate.webp" alt="CoatOfArms generate()" width="100%">
</div>

---

2. **HorizontalPlainFlag.generate()**: Generates the horizontal plain flag pattern as an array of strings. The method generates a flag based on the width, height and colors picked by the user. 
<div align="center">
  <img src="https://github.com/Serters/ConsoleCoatCraft/blob/main/console-coat-craft/src/main/resources/readme/webps/HorizontalPlainFlag_generate.webp" alt="HorizontalPlainFlag generate()" width="100%">
</div>

---

3. **Flag.display()**: Displays all types of Flags. 
<div align="center">
  <img src="https://github.com/Serters/ConsoleCoatCraft/blob/main/console-coat-craft/src/main/resources/readme/webps/Flag_display.webp" alt="HorizontalPlainFlag generate()" width="100%">
</div>

---

4. **ColorUtils.importBackgroundColors()** & **Utils.importData()**: Imports background colors data from a specified file and updates the corresponding data structure.
<div align="center">
  <img src="https://github.com/Serters/ConsoleCoatCraft/blob/main/console-coat-craft/src/main/resources/readme/webps/ColorUtils_importBackgroundColors.webp" alt="HorizontalPlainFlag generate()" width="100%">
</div>

<br>

<div align="center">
  <img src="https://github.com/Serters/ConsoleCoatCraft/blob/main/console-coat-craft/src/main/resources/readme/webps/Utils_importData.webp" width="100%">
</div>

---

