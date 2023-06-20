package com.example.personalgallery.data

import com.example.personalgallery.R
import com.example.personalgallery.model.ImageDescricaoId

class FonteDados {

    fun CarregaListDados():List<ImageDescricaoId>

    {
        return listOf<ImageDescricaoId>(

            ImageDescricaoId(R.drawable.foto_8, R.string.fotografia_8, R.string.data_8),
            ImageDescricaoId(R.drawable.imagem_1, R.string.fotografia_1, R.string.data_1),
            ImageDescricaoId(R.drawable.imagem_2, R.string.fotografia_2, R.string.data_2),
            ImageDescricaoId(R.drawable.imagem_3, R.string.fotografia_3, R.string.data_3),
            ImageDescricaoId(R.drawable.imagem_4, R.string.fotografia_4, R.string.data_4),
            ImageDescricaoId(R.drawable.imagem_5, R.string.fotografia_5, R.string.data_5),
            ImageDescricaoId(R.drawable.imagem_6, R.string.fotografia_6, R.string.data_6),
            ImageDescricaoId(R.drawable.imagem_7, R.string.fotografia_7, R.string.data_7),

        )
    }
}