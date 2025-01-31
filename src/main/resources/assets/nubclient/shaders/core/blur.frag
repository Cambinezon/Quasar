#version 150
uniform sampler2D Texture;
uniform vec2 ScreenSize;
uniform float BlurRadius;

in vec2 texCoords;
out vec4 FragColor;

const float weight[5] = float[](0.227027, 0.1945946, 0.1216216, 0.054054, 0.016216);

void main() {
    vec2 texelSize = 1.0 / ScreenSize;
    vec4 color = texture(Texture, texCoords) * weight[0];

    for (int i = 1; i < 5; i++) {
        color += texture(Texture, texCoords + vec2(texelSize.x * i, 0.0)) * weight[i];
        color += texture(Texture, texCoords - vec2(texelSize.x * i, 0.0)) * weight[i];
        color += texture(Texture, texCoords + vec2(0.0, texelSize.y * i)) * weight[i];
        color += texture(Texture, texCoords - vec2(0.0, texelSize.y * i)) * weight[i];
    }

    FragColor = color;
}
