import { useState } from 'react'
import { Fields } from '../Fields'
import { api } from '../../services/api'

interface ModalProps {
  isOpen: boolean
  onClose: () => void
}

export function Modal({ isOpen, onClose }: ModalProps) {
  const [nome, setNome] = useState('')
  const [marca, setMarca] = useState('')
  const modalStyle = isOpen ? 'block' : 'none'

  async function handleSubmit() {
    await api.post('/cadastrar', {
      nome,
      marca,
    })

    alert('Produto criado com sucesso!')

    onClose()
  }

  return (
    <div style={{ display: modalStyle }}>
      <div className="absolute bg-modal top-0 left-0 grid place-items-center h-screen w-screen">
        <div className="w-[40rem] bg-slate-100 p-6 flex flex-col gap-8 rounded">
          <div className="flex justify-between items-center">
            <h2 className="text-3xl">Adicionar Produto</h2>
            <button className="text-2xl" onClick={onClose}>
              &times;
            </button>
          </div>
          <div className="flex flex-col gap-6">
            <div className="flex gap-10 justify-between">
              <Fields
                labelText="Nome"
                id="Name"
                placeholder="Nome do produto"
                onChange={(e) => setNome(e.target.value)}
              />
              <Fields
                labelText="Marca"
                id="Marca"
                placeholder="Nome da Marca"
                onChange={(e) => setMarca(e.target.value)}
              />
            </div>
            <button
              onClick={handleSubmit}
              className="bg-purple-900 text-pink-200 font-medium p-2 rounded"
            >
              Adicionar
            </button>
          </div>
        </div>
      </div>
    </div>
  )
}
