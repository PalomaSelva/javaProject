import { useEffect, useState } from 'react'
import './styles/global.css'
import { api } from './services/api'
import { Modal } from './components/modal'

function App() {
  const [modal, setModal] = useState(false)
  const [datas, setDatas] = useState([])
  useEffect(() => {
    async function fetchList() {
      const response = await api.get(`/listar`)
      setDatas(response.data)
    }
    fetchList()
  }, [datas])

  return (
    <div className="relative h-screen flex bg-dark flex-col items-center p-14 gap-14">
      <h1 className="text-background font-bold text-6xl text-center">
        Lista de Produtos
      </h1>
      <div className="flex flex-col gap-3">
        <button
          className="w-fit text-pink-400 font-semibold px-2 py-1 rounded self-end"
          onClick={() => setModal(true)}
        >
          Adicionar
        </button>
        <table className="border-collapse w-[50rem] max-w-[90vw] p-3">
          <thead>
            <tr className="text-pink-400 bg-purple-900">
              <th className="text-left px-4 py-2 rounded-tl-lg">Código</th>
              <th className="text-center px-4 py-2">Nome</th>
              <th className="text-center px-4 py-2">Marca</th>
              <th className="text-center px-4 py-2 rounded-tr-lg">Ação</th>
            </tr>
          </thead>
          <tbody>
            {datas.map((data) => (
              <tr className="bg-gray-100" key={data.codigo}>
                <td className="text-left px-4 py-2">{data.codigo}</td>
                <td className="text-center px-4 py-2">{data.nome}</td>
                <td className="text-center px-4 py-2">{data.marca}</td>
                <td className="text-center px-4 py-2">ícone lixo</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      <div className="box">
        <div className="ellipse-wrapper">
          <div className="ellipse" />
        </div>
      </div>
      <Modal isOpen={modal} onClose={() => setModal(false)} />
    </div>
  )
}

export default App
