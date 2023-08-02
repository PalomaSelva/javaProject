/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ['./src/**/*.tsx'],
  theme: {
    extend: {
      colors: {
        background: '#EFD3BA',
        dark: '#151415',
        'purple-400': '#a79acf',
        'pink-400': '#C77DBB',
        'purple-900': '#3F4059',
        modal: '#00000033',
      },
    },
  },
  plugins: [],
}
