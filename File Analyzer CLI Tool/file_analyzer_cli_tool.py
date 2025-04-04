import nltk
import string
import tkinter as tk
from tkinter import filedialog
from collections import Counter
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize, sent_tokenize

# Download necessary NLTK resources
nltk.download('punkt')
nltk.download('stopwords')

def select_file():
    """ Opens a file dialog for the user to select a text file. """
    root = tk.Tk()
    root.withdraw()  # Hide the root window
    file_path = filedialog.askopenfilename(
        title="Select a Text File",
        filetypes=[("Text files", "*.txt")]
    )
    return file_path

def read_file(file_path):
    """ Reads the content of a given text file. """
    try:
        with open(file_path, 'r', encoding='utf-8') as file:
            return file.read()
    except Exception as e:
        print(f"Error reading file: {e}")
        return None

def process_text(text):
    """ Processes the text by tokenizing words and sentences while removing stop words. """
    words = word_tokenize(text)  # Tokenize words
    sentences = sent_tokenize(text)  # Tokenize sentences

    # Remove punctuation and convert to lowercase
    words = [word.lower() for word in words if word.isalpha()]

    # Remove common stopwords
    stop_words = set(stopwords.words('english'))
    words = [word for word in words if word not in stop_words]

    return words, sentences

def analyze_text(words, sentences):
    """ Analyzes the text to compute word count, top frequent words, average word length, and sentence count. """
    total_words = len(words)
    avg_word_length = sum(len(word) for word in words) / total_words if total_words > 0 else 0

    # Get the 5 most common words
    word_freq = Counter(words)
    most_common_words = word_freq.most_common(5)

    num_sentences = len(sentences)

    return total_words, most_common_words, avg_word_length, num_sentences

def print_results(total_words, most_common_words, avg_word_length, num_sentences):
    """ Prints the analysis results in a structured format. """
    print("\n📊 TEXT FILE ANALYSIS 📊\n")
    print(f"📌 Total Number of Words: {total_words}")
    print(f"📌 Number of Sentences: {num_sentences}")
    print(f"📌 Average Word Length: {avg_word_length:.2f} characters")

    print("\n🔝 Top 5 Most Frequent Words:")
    for word, frequency in most_common_words:
        print(f"   {word} - {frequency} times")

    print("\n✅ Analysis Complete!\n")

if __name__ == "__main__":
    file_path = select_file()

    if not file_path:
        print("No file selected. Exiting...")
    else:
        text_content = read_file(file_path)

        if text_content:
            words, sentences = process_text(text_content)
            total_words, most_common_words, avg_word_length, num_sentences = analyze_text(words, sentences)
            print_results(total_words, most_common_words, avg_word_length, num_sentences)
