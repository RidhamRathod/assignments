#  File Analyzer CLI Tool  

A Python-based **Command-Line Tool** that analyzes text files and provides insights like word count, sentence count, most frequent words, and average word length.

---

#  Features  
- Select a text file from your device using a file picker  
- Counts total words and sentences  
- Identifies the **top 5 most frequent words** (ignoring common stop words)  
- Calculates the **average word length**  
- Provides a **clean and structured output**  

---

#  Technologies Used  
- **Python** 
- **NLTK (Natural Language Toolkit)** → For text processing  
- **Tkinter** → For file selection dialog  
- **Collections (Counter)** → For word frequency analysis  

---

#  How I Built This  
1. Used `tkinter.filedialog` to allow users to **select a text file** instead of using command-line arguments.  
2. Used `nltk.tokenize` to split the file into **words and sentences**.  
3. Filtered out **stop words** (like *the, is, and*) to focus on meaningful words.  
4. Used `Counter` to identify the **top 5 most common words**.  
5. Formatted the output in a **user-friendly and structured way**.  

---

# Installation & Usage  
 Install Required Libraries  
Make sure you have Python installed, then install dependencies:  

pip install nltk
