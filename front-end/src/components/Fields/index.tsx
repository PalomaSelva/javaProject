import React from 'react'

interface FieldProps {
  labelText: string
  id: string
  placeholder?: string
  onChange?: (e: React.ChangeEvent<HTMLInputElement>) => void
}

export function Fields({ labelText, id, ...rest }: FieldProps) {
  return (
    <div className="flex flex-col gap-2 w-full">
      <label className="text-lg" htmlFor={id}>
        {labelText}
      </label>
      <input
        type="text"
        id={id}
        className="outline-none border-b-2 border-purple-400 bg-transparent h-7  w-full"
        {...rest}
      />
    </div>
  )
}
