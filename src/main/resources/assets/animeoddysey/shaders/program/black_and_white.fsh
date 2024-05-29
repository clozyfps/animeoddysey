#version 150

in vec2 texCoord;
out vec4 fragColor;
uniform sampler2D DiffuseSampler;

void main() {
    // Fetch the texture color
    vec4 texColor = texture(DiffuseSampler, texCoord);

    // Calculate the grayscale value
    float gray = dot(texColor.rgb, vec3(0.5, 0.5, 0.5));

    // Invert the grayscale value
    float invertedGray = 1.0 - gray;

    // Set the output color to the inverted grayscale value
    fragColor = vec4(vec3(invertedGray), texColor.a);
}
